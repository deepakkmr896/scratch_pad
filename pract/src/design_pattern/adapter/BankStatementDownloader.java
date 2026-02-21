package design_pattern.adapter;

import java.sql.Blob;

public interface BankStatementDownloader {
    Blob download(String sourceLocation);
}
