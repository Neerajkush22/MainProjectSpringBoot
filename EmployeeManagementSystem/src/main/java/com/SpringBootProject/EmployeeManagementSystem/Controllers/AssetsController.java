package com.SpringBootProject.EmployeeManagementSystem.Controllers;
import com.SpringBootProject.EmployeeManagementSystem.Models.Assets;
import com.SpringBootProject.EmployeeManagementSystem.Services.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Assets")
public class AssetsController {
    @Autowired
    private AssetsService assetsService;
    public AssetsController(AssetsService assetsService)
    {
        this.assetsService=assetsService;
    }
    @PostMapping
    public ResponseEntity<String> saveAssets(@RequestBody @Valid Assets assets)
    {
        assetsService.saveAssets(assets);
        return new ResponseEntity<String>("Asset Added Successfully",HttpStatus.CREATED);
    }


    @GetMapping
    public List<Assets> getAllAssets(){
        return assetsService.getAllAssets();
    }


    @GetMapping("/getById/{id}")
    public  ResponseEntity<Assets> getAssetsById(@PathVariable("id")int id)
    {
        return new ResponseEntity<Assets>(assetsService.getAssetById(id),HttpStatus.OK);
    }


    @PutMapping("/updateById/{id}")
    public ResponseEntity<String> updateAssets(@PathVariable("id")int id, @RequestBody @Valid Assets assets)
    {
        assetsService.updateAssets(assets,id);
        return new ResponseEntity<String>("Asset Updated Successfully",HttpStatus.OK);
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteAssets(@PathVariable("id")int id)
    {
        assetsService.deleteAssets(id);
        return new ResponseEntity<String>("Asset Deleted Successfully",HttpStatus.OK);
    }
}
