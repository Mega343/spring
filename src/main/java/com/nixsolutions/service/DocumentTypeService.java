package com.nixsolutions.service;

import com.nixsolutions.bean.DocumentType;

import java.util.List;

public interface DocumentTypeService {

    public boolean add(DocumentType docType);

    public boolean edit(DocumentType docType);

    public boolean delete(Integer id);

    public DocumentType getDocumentType(Integer id);

    public List<DocumentType> findDocumentTypeByName(String name);

    public List<DocumentType> getAllDocumentTypes();
}
