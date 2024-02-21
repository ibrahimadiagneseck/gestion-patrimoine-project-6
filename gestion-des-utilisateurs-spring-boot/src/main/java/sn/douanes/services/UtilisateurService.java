package sn.douanes.services;

import org.springframework.web.multipart.MultipartFile;
import sn.douanes.exception.entities.*;
import sn.douanes.model.Agent;
import sn.douanes.model.Utilisateur;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface UtilisateurService {

    // Utilisateur register(Utilisateur utilisateur) throws UserNotFoundException, EmailExistException, MessagingException;

    List<Utilisateur> getUsers();

    Utilisateur findByMatriculeAgent(Agent agent);

    Utilisateur getUserByUserName(String userName);

    Utilisateur registerUser(Utilisateur utilisateur) throws UserNotFoundException, AgentExistException, IOException, NotAnImageFileException, MessagingException;

    Utilisateur addNewUser(Utilisateur utilisateur) throws UserNotFoundException, AgentExistException, IOException, NotAnImageFileException, MessagingException;

    Utilisateur updateUser(Utilisateur utilisateur) throws UserNotFoundException, EmailExistException, IOException, NotAnImageFileException;

    void deleteUserByMatriculeAgent(Agent agent) throws IOException;

    void resetPasswordByMatriculeAgent(Agent agent) throws MessagingException, AgentNotFoundException;

    // User updateProfileImage(String username, MultipartFile profileImage) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, NotAnImageFileException;

}
