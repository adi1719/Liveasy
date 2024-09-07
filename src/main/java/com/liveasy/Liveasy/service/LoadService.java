package com.liveasy.Liveasy.service;

import com.liveasy.Liveasy.dto.LoadDTO;
import com.liveasy.Liveasy.model.Load;
import com.liveasy.Liveasy.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LoadService {

    @Autowired
    private LoadRepository loadRepository;

    public String addLoad(LoadDTO loadDTO) {
        Load load = new Load();
        load.setLoadingPoint(loadDTO.getLoadingPoint());
        load.setUnloadingPoint(loadDTO.getUnloadingPoint());
        load.setProductType(loadDTO.getProductType());
        load.setTruckType(loadDTO.getTruckType());
        load.setNoOfTrucks(loadDTO.getNoOfTrucks());
        load.setWeight(loadDTO.getWeight());
        load.setComment(loadDTO.getComment());
        load.setShipperId(loadDTO.getShipperId());
        load.setDate(loadDTO.getDate() != null ? loadDTO.getDate() : LocalDate.now());

        loadRepository.save(load);
        return "Load details added successfully";
    }

    public List<Load> getLoadsByShipper(String shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    public Optional<Load> getLoadById(String loadId) {
        return loadRepository.findById(loadId);
    }

    public String updateLoad(String loadId, LoadDTO loadDTO) {
        Optional<Load> existingLoad = loadRepository.findById(loadId);
        if (existingLoad.isPresent()) {
            Load load = existingLoad.get();
            load.setLoadingPoint(loadDTO.getLoadingPoint());
            load.setUnloadingPoint(loadDTO.getUnloadingPoint());
            load.setProductType(loadDTO.getProductType());
            load.setTruckType(loadDTO.getTruckType());
            load.setNoOfTrucks(loadDTO.getNoOfTrucks());
            load.setWeight(loadDTO.getWeight());
            load.setComment(loadDTO.getComment());
            load.setDate(loadDTO.getDate());

            loadRepository.save(load);
            return "Load updated successfully";
        }
        return "Load not found";
    }

    public String deleteLoad(String loadId) {
        if (loadRepository.existsById(loadId)) {
            loadRepository.deleteById(loadId);
            return "Load deleted successfully";
        }
        return "Load not found";
    }
}
