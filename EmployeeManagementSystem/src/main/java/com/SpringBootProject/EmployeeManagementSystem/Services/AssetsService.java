package com.SpringBootProject.EmployeeManagementSystem.Services;

import com.SpringBootProject.EmployeeManagementSystem.Models.Assets;

import java.util.List;

public interface AssetsService {
    Assets saveAssets(Assets assets);
    List<Assets> getAllAssets();
    Assets getAssetById(int id);
    Assets updateAssets(Assets assets, int id);
    void deleteAssets(int id);
}
