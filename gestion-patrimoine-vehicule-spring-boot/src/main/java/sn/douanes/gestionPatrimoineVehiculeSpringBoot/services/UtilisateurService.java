package sn.douanes.gestionPatrimoineVehiculeSpringBoot.services;


import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Agent;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Utilisateur;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.exception.entities.AgentExistException;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.exception.entities.AgentNotFoundException;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.exception.entities.EmailExistException;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.exception.entities.UserNotFoundException;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface UtilisateurService {

    // Utilisateur register(Utilisateur utilisateur) throws UserNotFoundException, EmailExistException, MessagingException;

    List<Utilisateur> getUsers();

    Utilisateur findByMatriculeAgent(Agent agent);

    Utilisateur getUserByUserName(String userName);

    Utilisateur registerUser(Utilisateur utilisateur) throws UserNotFoundException, AgentExistException, IOException, MessagingException;

    Utilisateur addNewUser(Utilisateur utilisateur) throws UserNotFoundException, AgentExistException, IOException, MessagingException;

    Utilisateur updateUser(Utilisateur utilisateur) throws UserNotFoundException, EmailExistException, IOException;

    void deleteUserByMatriculeAgent(Agent agent) throws IOException;

    void resetPasswordByMatriculeAgent(Agent agent) throws MessagingException, AgentNotFoundException;

    // User updateProfileImage(String username, MultipartFile profileImage) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, NotAnImageFileException;

}
