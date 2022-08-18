package com.SpringBootProject.EmployeeManagementSystem.Controllers;

import com.SpringBootProject.EmployeeManagementSystem.Models.Assets;
import com.SpringBootProject.EmployeeManagementSystem.Models.Employee;
import com.SpringBootProject.EmployeeManagementSystem.Services.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<String> saveAssets(@RequestBody Assets assets)
    {
        if(assets.getBills().length()>0&&assets.getFurniture().length()>0&&assets.getGadgets().length()>0) {
            assetsService.saveAssets(assets);
            return new ResponseEntity<String>("**** Asset Added Successfully ****", HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<String>("Enter Valid details",HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping
    public ResponseEntity< List<Assets>> getAllAssets(){
        List<Assets>  assets=assetsService.getAllAssets();
        if(assets.size()>0){
            return new ResponseEntity<>(assets,HttpStatus.OK);
        }
        else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getById/{id}")
    public  ResponseEntity<Assets> getAssetsById(@PathVariable("id")int id)
    {
        try{
            return new ResponseEntity<Assets>(assetsService.getAssetById(id),HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Assets>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/updateById/{id}")
    public ResponseEntity<String> updateAssets(@PathVariable("id")int id, @RequestBody Assets assets)
    {
        try {
            if(assets.getBills().length()>0&&assets.getFurniture().length()>0&&assets.getGadgets().length()>0) {
                assetsService.updateAssets(assets, id);
                return new ResponseEntity<String>("Assets details updated Successfully", HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<String>("Enter valid details for updation",HttpStatus.BAD_REQUEST);
            }
        }
        catch (NoSuchElementException e)
        {

            return new ResponseEntity<String>("Assets details not found", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteAssets(@PathVariable("id")int id)
    {
        try {
            assetsService.deleteAssets(id);
            return new ResponseEntity<String>("**** Assets has been deleted! ****",HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {

            return new ResponseEntity<String>("**** Asset not present ****",HttpStatus.NOT_FOUND);
        }
    }
}
