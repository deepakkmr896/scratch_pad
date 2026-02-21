package design_pattern.adapter;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws SQLException {
        BankStatementLocator bankStatementLocator = new BankStatementLocator("aws.blob/id=1");
        BankStatementDownloader bankStatementDownloader = new BankStatementByteAdapter(bankStatementLocator);
        Blob blobData =  bankStatementDownloader.download(null);
        int lengthBlob = (int) (blobData.length());
        System.out.println(Base64.getEncoder().encodeToString(blobData.getBytes(1, lengthBlob)));
    }
}
