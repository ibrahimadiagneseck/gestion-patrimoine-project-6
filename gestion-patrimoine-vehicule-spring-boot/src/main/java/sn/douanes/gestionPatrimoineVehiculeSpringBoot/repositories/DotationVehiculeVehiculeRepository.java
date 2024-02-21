package sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.DotationVehiculeVehicule;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Vehicule;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.keys.DotationVehiculeVehiculeId;

@Repository
public interface DotationVehiculeVehiculeRepository extends JpaRepository<DotationVehiculeVehicule, DotationVehiculeVehiculeId> {

    DotationVehiculeVehicule findByNumeroSerie(Vehicule numeroSerie);
}
