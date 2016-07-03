package data_access;

import model.Algorithm;
import model.AlgorithmFamily;
import model.Token;
import util.Queries;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;

/**
 * Created by Idan Stark on 03/07/16.
 */
public class FilesDatabase implements Database{

    private Path rootPath;

    public FilesDatabase(String rootUri){
        this.rootPath = Paths.get(rootUri);
    }

    @Override
    public Iterable<AlgorithmFamily> getAllAlgorithemFamilies() {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(rootPath)) {
            return new Queries<>(stream).select(p -> new AlgorithmFamily(p.getFileName().toString()));
        } catch (IOException | DirectoryIteratorException e) {
            //TODO log error
        }
        return new ArrayList<>();
    }

    @Override
    public Iterable<Algorithm> getAlgorithmsInFamily(AlgorithmFamily family) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(rootPath)) {
            return new Queries<>(stream).select(p -> {
                Algorithm algorithm = new Algorithm(p.getFileName().toString());
                try {
                    Path filePath = Paths.get(rootPath.toString(), family.getName(), algorithm.getName());
                    for(String line : Files.readAllLines(filePath)){
                        algorithm.getActions().add(new Token(line));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return algorithm;
            });
        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void addAlgorithmFamily(AlgorithmFamily family) {
        try {
            Files.createDirectory(Paths.get(rootPath.toString(), family.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAlgorithmToFamily(AlgorithmFamily family, Algorithm algorithm) {
        try {
            Path filePath = Paths.get(rootPath.toString(), family.getName(), algorithm.getName());
            Files.createFile(filePath);
            Iterable<String> lines = new Queries<>(algorithm.getTokens()).select(t -> t.toString());
            Files.write(filePath, lines, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean removeAlgorithmFromFamily(AlgorithmFamily family, Algorithm algorithm) {
        try {
            Path filePath = Paths.get(rootPath.toString(), family.getName(), algorithm.getName());
            Files.delete(filePath);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
