package com.springai.multimodel.service;

public interface MultiModelService {
    String askGPT(String message);
    String askOllama(String message);
}
