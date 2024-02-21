package sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.impl;


import jakarta.transaction.Transactional;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Agent;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.entities.Utilisateur;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.exception.entities.AgentExistException;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.exception.entities.AgentNotFoundException;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.exception.entities.EmailExistException;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.exception.entities.UserNotFoundException;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories.AgentRepository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.repositories.UtilisateurRepository;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.EmailService;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.LoginAttemptService;
import sn.douanes.gestionPatrimoineVehiculeSpringBoot.services.UtilisateurService;


import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static sn.douanes.gestionPatrimoineVehiculeSpringBoot.constants.UserImplConstant.AGENT_ALREADY_EXISTS;
import static sn.douanes.gestionPatrimoineVehiculeSpringBoot.constants.UserImplConstant.NO_USER_FOUND_BY_AGENT;


@Service
@Transactional
@Qualifier("userDetailsService")
public class UtilisateurServiceImpl implements UtilisateurService {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UtilisateurRepository utilisateurRepository;


    // private BCryptPasswordEncoder passwordEncoder;
    private LoginAttemptService loginAttemptService;
    private EmailService emailService;

    private AgentRepository agentRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, LoginAttemptService loginAttemptService, EmailService emailService, AgentRepository agentRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.loginAttemptService = loginAttemptService;
        this.emailService = emailService;
        this.agentRepository = agentRepository;
    }

    @Override
    public List<Utilisateur> getUsers() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur getUserByUserName(String userName) {
        return utilisateurRepository.findByUserName(userName);
    }

    @Override
    public Utilisateur findByMatriculeAgent(Agent agent) {
        return utilisateurRepository.findByMatriculeAgent(agent);
    }

    @Override
    public Utilisateur registerUser(Utilisateur utilisateur) throws UserNotFoundException, AgentExistException, IOException, MessagingException {

        validateNewEmail(EMPTY, utilisateur.getMatriculeAgent().getEmailAgent());

        Utilisateur user = new Utilisateur();

        String userName = utilisateur.getMatriculeAgent().getMatriculeAgent();

        // String clearPwd = generatePassword();
        String clearPwd = utilisateur.getMatriculeAgent().getMatriculeAgent();
        String hashPwd = passwordEncoder.encode(clearPwd);
        user.setPwd(hashPwd);
        user.setJoinDate(new Date(System.currentTimeMillis()));
        user.setMatriculeAgent(utilisateur.getMatriculeAgent());

        user.setUserName(userName);

        user.setRole("ROLE_USER");
        user.setAuthorities(utilisateur.getAuthorities());
        // utilisateur.setAuthorities(Role.ROLE_USER.getAuthorities());

        user.setActive(utilisateur.getActive());
        user.setNotLocked(utilisateur.getNotLocked());


        user.setActive(true);
        user.setNotLocked(true);

        utilisateurRepository.save(user);
        emailService.sendNewPasswordEmail(user.getMatriculeAgent().getPrenomAgent(), clearPwd, user.getMatriculeAgent().getEmailAgent());
        return user;
    }

    @Override
    public Utilisateur addNewUser(Utilisateur utilisateur) throws UserNotFoundException, AgentExistException, IOException, MessagingException {

        validateNewEmail(EMPTY, utilisateur.getMatriculeAgent().getEmailAgent());

        Utilisateur user = new Utilisateur();

        String userName = utilisateur.getMatriculeAgent().getMatriculeAgent();

        // String clearPwd = generatePassword();
        String clearPwd = utilisateur.getMatriculeAgent().getMatriculeAgent();
        String hashPwd = passwordEncoder.encode(clearPwd);
        user.setPwd(hashPwd);
        user.setJoinDate(new Date(System.currentTimeMillis()));
        user.setMatriculeAgent(utilisateur.getMatriculeAgent());

        user.setUserName(userName);

        user.setRole("ROLE_USER");
        // user.setRole(utilisateur.getRole());
        user.setAuthorities(utilisateur.getAuthorities());

        user.setActive(utilisateur.getActive());
        user.setNotLocked(utilisateur.getNotLocked());

        utilisateurRepository.save(user);
        // saveProfileImage(user, profileImage);
        // LOGGER.info("New user password: " + clearPwd);
        emailService.sendNewPasswordEmail(user.getMatriculeAgent().getPrenomAgent(), clearPwd, user.getMatriculeAgent().getEmailAgent());
        return user;
    }

    @Override
    public Utilisateur updateUser(Utilisateur utilisateur) throws UserNotFoundException, EmailExistException, IOException {
        return null;
    }

    @Override
    public void deleteUserByMatriculeAgent(Agent agent) throws IOException {

    }

    @Override
    public void resetPasswordByMatriculeAgent(Agent agent) throws MessagingException, AgentNotFoundException {
        Utilisateur user = utilisateurRepository.findByMatriculeAgent(agent);

        if (user == null) {
            throw new AgentNotFoundException(NO_USER_FOUND_BY_AGENT + agent.getPrenomAgent() + " " + agent.getNomAgent());
        }

        // String password = generatePassword();
        String password = agent.getMatriculeAgent();
        user.setPwd(encodePassword(password));

        utilisateurRepository.save(user);
        // LOGGER.info("New user password: " + password);
        emailService.sendNewPasswordEmail(user.getMatriculeAgent().getPrenomAgent(), password, user.getMatriculeAgent().getEmailAgent());
    }


    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    private String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    private String generateUserId() {
        return RandomStringUtils.randomNumeric(10);
    }

    private Utilisateur validateNewEmail(String currentEmail, String newEmail) throws UserNotFoundException, AgentExistException {

        Agent agent = agentRepository.findByEmailAgent(newEmail);
        Utilisateur userByNewAgent = utilisateurRepository.findByMatriculeAgent(agent);

        if(StringUtils.isNotBlank(currentEmail)) {

            Agent currentAgent = agentRepository.findByEmailAgent(currentEmail);
            Utilisateur currentUser = utilisateurRepository.findByMatriculeAgent(currentAgent);

            if(currentUser == null) {
                throw new UserNotFoundException(NO_USER_FOUND_BY_AGENT + agent.getPrenomAgent() + " " + agent.getNomAgent());
            }
            if(userByNewAgent != null && !currentUser.getUtilisateurId().equals(userByNewAgent.getUtilisateurId())) {
                throw new AgentExistException(AGENT_ALREADY_EXISTS);
            }

            return currentUser;

        } else {

            if(userByNewAgent != null) {
                throw new AgentExistException(AGENT_ALREADY_EXISTS);
            }

            return null;
        }
    }
}


