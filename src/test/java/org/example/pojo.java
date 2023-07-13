package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.util.ArrayList;

import lombok.NoArgsConstructor;
import org.example.Support;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder



//@JsonIgnoreProperties(ignoreUnknown = true)
public class pojo {

    private float page;
    private float per_page;
    private float total;
    private float total_pages;
    ArrayList<Object> data = new ArrayList<Object>();
    public Support support;
}
