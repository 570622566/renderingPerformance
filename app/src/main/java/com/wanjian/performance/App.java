package com.wanjian.performance;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import wanjian.renderingperformance.RenderingPerformance;
import wanjian.renderingperformance.config.Config;
import wanjian.renderingperformance.graph.DefaultPagePerformanceGraph;
import wanjian.renderingperformance.graph.PolylineChartPagePerformance;

/**
 * Created by wanjian on 2017/3/5.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Config config = new Config.Build(this)
//                .timeInterval(100)
                .pagePerformanceGraph(new DefaultPagePerformanceGraph(this) {
                    @Override
                    protected int getFactor() {
                        return super.getFactor() * 20;
                    }

                    @Override
                    protected int getGraphColor() {
                        return 0x660000ff;
                    }
                })
                .build();

        RenderingPerformance.init(this, config);
    }
}
