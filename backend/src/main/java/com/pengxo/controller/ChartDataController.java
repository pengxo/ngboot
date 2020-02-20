package com.pengxo.controller;

import com.pengxo.data.ChartSeriesData;
import com.pengxo.data.DataGenerator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ChartDataController {

    @GetMapping(path = "/chart")
    public List<ChartSeriesData> getAllChartData() {
        return DataGenerator.getInstance().getChartSeriesData();
    }
}
