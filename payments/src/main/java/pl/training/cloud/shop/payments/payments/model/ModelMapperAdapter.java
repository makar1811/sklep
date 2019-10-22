package pl.training.cloud.shop.payments.payments.model;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ModelMapperAdapter implements Mapper {

    @Override
    public <S, T> T map(S source, Class<T> type) {
        return new ModelMapper().map(source, type);
    }

    @Override
    public <S, T> void map(S source, T target) {
        new ModelMapper().map(source, target);
    }

    @Override
    public <S, T> List<T> map(List<S> source, Class<T> type) {
        ModelMapper modelMapper = new ModelMapper();
        return source.stream()
                .map(element -> modelMapper.map(element, type))
                .collect(toList());
    }

}
