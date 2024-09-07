package com.liveasy.Liveasy.controller;

import com.liveasy.Liveasy.dto.LoadDTO;
import com.liveasy.Liveasy.model.Load;
import com.liveasy.Liveasy.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadService loadService;

    @PostMapping
    public String addLoad(@RequestBody LoadDTO loadDTO) {
        return loadService.addLoad(loadDTO);
    }

    @GetMapping
    public List<Load> getLoadsByShipper(@RequestParam String shipperId) {
        return loadService.getLoadsByShipper(shipperId);
    }

    @GetMapping("/{loadId}")
    public Optional<Load> getLoadById(@PathVariable String loadId) {
        return loadService.getLoadById(loadId);
    }

    @PutMapping("/{loadId}")
    public String updateLoad(@PathVariable String loadId, @RequestBody LoadDTO loadDTO) {
        return loadService.updateLoad(loadId, loadDTO);
    }

    @DeleteMapping("/{loadId}")
    public String deleteLoad(@PathVariable String loadId) {
        return loadService.deleteLoad(loadId);
    }
}
