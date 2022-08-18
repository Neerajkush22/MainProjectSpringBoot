package com.SpringBootProject.EmployeeManagementSystem.Services;

import com.SpringBootProject.EmployeeManagementSystem.Models.Assets;
import com.SpringBootProject.EmployeeManagementSystem.Repository.AssetsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetsServiceImp implements AssetsService {
    @Autowired
    private AssetsRepo assetsRepo;
    public AssetsServiceImp(AssetsRepo assetsRepo)
    {
        this.assetsRepo=assetsRepo;
    }
    @Override
    public Assets saveAssets(Assets assets)
    {
        return assetsRepo.save(assets);
    }
    @Override
    public List<Assets> getAllAssets()
    {
        return assetsRepo.findAll();
    }
    @Override
    public Assets getAssetById(int id)
    {
        return assetsRepo.findById(id).orElseThrow();
    }
    @Override
    public Assets updateAssets(Assets assets, int id)
    {
        Assets existingAssets = assetsRepo.findById(id).orElseThrow();
        existingAssets.setBills(assets.getBills());
        existingAssets.setFurniture(assets.getFurniture());
        existingAssets.setGadgets(assets.getGadgets());
        assetsRepo.save(existingAssets);
        return existingAssets;
    }
    @Override
    public void deleteAssets(int id)
    {
        assetsRepo.findById(id).orElseThrow();
        assetsRepo.deleteById(id);
    }
}
