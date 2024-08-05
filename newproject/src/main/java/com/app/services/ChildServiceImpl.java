package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ChildDTO;
import com.app.entity.Child;
import com.app.repository.ChildRepository;

@Service
@Transactional
public class ChildServiceImpl implements ChildService {

    @Autowired
    private final ChildRepository childRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public ChildServiceImpl(ChildRepository childRepository, ModelMapper modelMapper) {
        this.childRepository = childRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ChildDTO createChild(ChildDTO childDTO) {
        Child child = modelMapper.map(childDTO, Child.class);
        child = childRepository.save(child);
        return modelMapper.map(child, ChildDTO.class);
    }

    @Override
    public ChildDTO getChildById(int id) {
        Child child = childRepository.findById(id).orElseThrow();
        return modelMapper.map(child, ChildDTO.class);
    }

    @Override
    public List<ChildDTO> getAllChildren() {
        return childRepository.findAll().stream()
                .map(child -> modelMapper.map(child, ChildDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ChildDTO updateChild(int id, ChildDTO childDTO) {
        Child child = childRepository.findById(id).orElseThrow();
        modelMapper.map(childDTO, child);
        child = childRepository.save(child);
        return modelMapper.map(child, ChildDTO.class);
    }

    @Override
    public void deleteChild(int id) {
        childRepository.deleteById(id);
    }
}
