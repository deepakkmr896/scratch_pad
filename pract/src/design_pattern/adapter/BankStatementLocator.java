package design_pattern.adapter;

import java.util.Base64;

public class BankStatementLocator {
    private final String fileLocation;

    public BankStatementLocator(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public byte[] getByteFileLocation() {
        return Base64.getEncoder().encode(fileLocation.getBytes());
    }
}
