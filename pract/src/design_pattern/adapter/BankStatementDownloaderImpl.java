package design_pattern.adapter;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.sql.SQLException;

public class BankStatementDownloaderImpl implements BankStatementDownloader {
    @Override
    public Blob download(String sourceLocation) {
        // retrieve the BLOB from source
        return BankStatementDownloaderImpl.getBlobData(sourceLocation);
    }

    private static Blob getBlobData(String location) {
        // retrieve the data
        String data = "Hello There";
        try {
            return new SerialBlob(data.getBytes());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
