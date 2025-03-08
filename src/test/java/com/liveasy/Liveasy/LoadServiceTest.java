package com.liveasy.Liveasy;

import com.liveasy.Liveasy.dto.LoadDTO;
import com.liveasy.Liveasy.model.Load;
import com.liveasy.Liveasy.repository.LoadRepository;
import com.liveasy.Liveasy.service.LoadService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class LoadServiceTest {

    @Mock
    private LoadRepository loadRepository;

    @InjectMocks
    private LoadService loadService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddLoad() {
        LoadDTO loadDTO = new LoadDTO();
        loadDTO.setLoadingPoint("Point A");
        loadDTO.setUnloadingPoint("Point B");
        loadDTO.setProductType("Type A");
        loadDTO.setTruckType("Type B");
        loadDTO.setNoOfTrucks(5);
        loadDTO.setWeight(1000);
        loadDTO.setComment("Test Comment");
        loadDTO.setShipperId("Shipper123");
        loadDTO.setDate(LocalDate.now());

        String result = loadService.addLoad(loadDTO);

        verify(loadRepository, times(1)).save(any(Load.class));
        assertEquals("Load details added successfully", result);
    }

    @Test
    public void testGetLoadsByShipper() {
        Load load = new Load();
        load.setShipperId("Shipper123");
        when(loadRepository.findByShipperId("Shipper123")).thenReturn(Arrays.asList(load));

        List<Load> loads = loadService.getLoadsByShipper("Shipper123");

        assertEquals(1, loads.size());
        assertEquals("Shipper123", loads.get(0).getShipperId());
    }

    @Test
    public void testGetLoadById() {
        Load load = new Load();
        load.setLoadId("Load123");
        when(loadRepository.findById("Load123")).thenReturn(Optional.of(load));

        Optional<Load> result = loadService.getLoadById("Load123");

        assertTrue(result.isPresent());
        assertEquals("Load123", result.get().getLoadId());
    }

    @Test
    public void testUpdateLoad() {
        Load load = new Load();
        load.setLoadId("Load123");
        when(loadRepository.findById("Load123")).thenReturn(Optional.of(load));

        LoadDTO loadDTO = new LoadDTO();
        loadDTO.setLoadingPoint("Point A");
        loadDTO.setUnloadingPoint("Point B");
        loadDTO.setProductType("Type A");
        loadDTO.setTruckType("Type B");
        loadDTO.setNoOfTrucks(5);
        loadDTO.setWeight(1000);
        loadDTO.setComment("Updated Comment");
        loadDTO.setDate(LocalDate.now());

        String result = loadService.updateLoad("Load123", loadDTO);

        verify(loadRepository, times(1)).save(any(Load.class));
        assertEquals("Load updated successfully", result);
    }

    @Test
    public void testDeleteLoad() {
        when(loadRepository.existsById("Load123")).thenReturn(true);

        String result = loadService.deleteLoad("Load123");

        verify(loadRepository, times(1)).deleteById("Load123");
        assertEquals("Load deleted successfully", result);
    }
}