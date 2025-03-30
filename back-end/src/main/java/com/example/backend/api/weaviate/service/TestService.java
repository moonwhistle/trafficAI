package com.example.backend.api.weaviate.service;
import io.weaviate.client.WeaviateClient;
import io.weaviate.client.base.Result;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    private final WeaviateClient weaviateClient;

    public TestService(WeaviateClient weaviateClient) {
        this.weaviateClient = weaviateClient;
    }

    public void delete() {
        List<String> classNames = List.of(
                //"Address_Master"
                //"EstimatedSales"
                //"Passenger",
                //"Store",
                //"Population",
                //"OfficetelValuation"
                //"ExpenditureCommercialDistrict","EstimatedSales"
        );

        List<Result<Boolean>> deleteResults = new ArrayList<>();

        for (String className : classNames) {
            Result<Boolean> deleteResult = weaviateClient.schema().classDeleter().withClassName(className).run();
            deleteResults.add(deleteResult);
        }

        for (int i = 0; i < deleteResults.size(); i++) {
            Result<Boolean> result = deleteResults.get(i);
            String className = classNames.get(i);

            if (result.hasErrors()) {
                System.out.println(className + " 클래스 삭제 실패: " + result.getError());
            } else {
                System.out.println(className + " 클래스 삭제 성공");
            }
        }
    }

}
