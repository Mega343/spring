package com.nixsolutions.service;

import com.nixsolutions.bean.Document;

public interface DocumentService {

    public boolean add(Document document);

    public boolean edit(Document document);

    public boolean delete(Integer id);

    public Document getDocument(Integer id);
}
