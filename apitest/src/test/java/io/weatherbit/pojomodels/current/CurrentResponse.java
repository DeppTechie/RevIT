package io.weatherbit.pojomodels.current;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentResponse {

    @SerializedName("data")
    @Expose
    private List<Data> data = null;
    @SerializedName("count")
    @Expose
    private Integer count;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
