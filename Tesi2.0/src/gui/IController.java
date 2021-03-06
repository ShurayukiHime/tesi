package gui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import model.services.IService;

public interface IController {

	public void createMyDataUser(String firstName, String lastName, Date dateOfBirth, String emailAddress, char[] password);

	public void logInUser(String email, char[] password);

	public void toggleStatus(IService selectedService, boolean status);

	public String getAllSConsents(IService selectedService);

	public void addService(IService selectedService);

	public void withdrawConsentForService(IService selectedService);

	public List<IService> getAllActiveServicesForUser();

	public boolean getADStatusForService(IService selectedService);

	public UserInteractor getUserInteractor();

	public void setActualPosition(double lat, double lon);

	public void setPanelDate(JTextField day, JTextField month, JTextField year, JTextField hour, JTextField min);

	public JFrame getServicePanel(IService selectedService);

	public void provideMlntService(MainFrame mainFrame) throws FileNotFoundException, IOException;

	public void resetUIPreferences();

	public void fillPreferencesByCategory(String string, List<JCheckBox> checksAmenity);

	public void addUIPreference(String category, String name);

	public void updateModel(MainFrame mainFrame);

	public void addNewServiceConsent(IService selectedService);

	public void setDate(JTextField day, JTextField month, JTextField year, JTextField hour, JTextField min);

	public String getAllDConsents(IService selectedService);

}
