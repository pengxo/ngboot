package com.pengxo.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {

	private final List<ChartSeriesData> datas = new ArrayList<>();

	private Random random;

	private DataGenerator() {
		initData();
	}

	public synchronized static DataGenerator getInstance() {
		return new DataGenerator();
	}

	private void initData() {
		if (random == null)
			random = new Random();
		datas.add(new ChartSeriesData("2010", generateValue(), generateValue()));
		datas.add(new ChartSeriesData("2011", generateValue(), generateValue()));
		datas.add(new ChartSeriesData("2012", generateValue(), generateValue()));
		datas.add(new ChartSeriesData("2013", generateValue(), generateValue()));
		datas.add(new ChartSeriesData("2014", generateValue(), generateValue()));
		datas.add(new ChartSeriesData("2015", generateValue(), generateValue()));
		datas.add(new ChartSeriesData("2016", generateValue(), generateValue()));
		datas.add(new ChartSeriesData("2017", generateValue(), generateValue()));
		datas.add(new ChartSeriesData("2018", generateValue(), generateValue()));
		datas.add(new ChartSeriesData("2019", generateValue(), generateValue()));
		datas.add(new ChartSeriesData("2020", generateValue(), generateValue()));
	}

	private int generateValue() {
		return random.nextInt(10) * 10;
	}

	public List<ChartSeriesData> getChartSeriesData() {
		return datas;
	}
}
