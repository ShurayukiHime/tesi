package model.MyData;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import model.mapfeatures.ITrip;
import model.mapfeatures.Position;
import model.userdata.ICalendar;
import model.userdata.IPreference;

public interface IPersonalDataVault {
	public List<ITrip> getAllTrip();

	public void addTrip(ITrip trip);

	public ICalendar getCalendar();

	public List<IPreference> getPreferences();

	public void setPreferences(List<IPreference> preferences);

	public Position getPositionByDate(LocalDateTime date);

	public IDataSet getData(Set<String> typesConst);

	public void saveData(IDataSet dataSet);
}
