package sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Vidange;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories.VidangeRepository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.VidangeService;


@Service
public class VidangeServiceImpl implements VidangeService {

    @Autowired
    VidangeRepository vidangeRepository;

    @Override
    public Vidange saveVidange(Vidange v) {
        return vidangeRepository.save(v);
    }

    @Override
    public Vidange updateVidange(Vidange v) {
        return vidangeRepository.save(v);
    }

    @Override
    public void deleteVidange(Vidange v) {
        vidangeRepository.delete(v);
    }

    @Override
    public void deleteVidangeById(String id) {
        vidangeRepository.deleteById(id);
    }

    @Override
    public Vidange getVidange(String id) {
        return vidangeRepository.findById(id).get();
    }

    @Override
    public List<Vidange> getAllVidanges() {
        return vidangeRepository.findAll();
    }



}
