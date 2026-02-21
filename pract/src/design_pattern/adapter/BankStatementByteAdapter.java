package design_pattern.adapter;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;

public class BankStatementByteAdapter implements BankStatementDownloader {
    private final BankStatementLocator bankStatementLocator;

    public BankStatementByteAdapter(BankStatementLocator bankStatementLocator) {
        this.bankStatementLocator = bankStatementLocator;
    }

    @Override
    public Blob download(String sourceLocation) {
        byte[] locationByte = bankStatementLocator.getByteFileLocation();
        String data = new String(locationByte);
        try {
            return new SerialBlob(data.getBytes());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public BankStatementLocator getBankStatementLocator() {
        return bankStatementLocator;
    }
}
