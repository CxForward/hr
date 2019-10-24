package pc.hcy.learn.service.impl;

import java.util.List;

import pc.hcy.learn.dao.TrainDao;
import pc.hcy.learn.dao.impl.TrainDaoImpl;
import pc.hcy.learn.pojo.Train;
import pc.hcy.learn.service.TrainService;

public class TrainServiceImpl implements TrainService {
    private TrainDao trainDao = new TrainDaoImpl();

    @Override
    public void saveTrain(Train train) {
        trainDao.save(train);
    }

    @Override
    public List findAllTrains() {
        return trainDao.findAllTrains();
    }

    @Override
    public List<Train> findTrainByEducate(String educate) {
        return trainDao.findTrainByEducate(educate);
    }

    @Override
    public Train findTrainById(String id) {
        return trainDao.findTrainById(id);
    }

    @Override
    public void updateTrain(Train train) {
        trainDao.updateTrain(train);
    }

    @Override
    public void delete(String id) {
        trainDao.delete(id);
    }
}
