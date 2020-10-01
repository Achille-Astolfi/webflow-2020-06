package com.example.corso.flow.serviceimpl;

import com.example.corso.flow.service.DoubleService;
import org.springframework.stereotype.Service;

@Service
public class DoubleServiceImpl implements DoubleService {
    @Override
    public double sumAsDouble(double add1, double add2) {
        return add1 + add2;
    }
}
