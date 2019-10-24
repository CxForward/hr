package pc.hcy.learn.service;

import java.util.List;

import pc.hcy.learn.pojo.Train;

public interface TrainService {
    void saveTrain(Train train);

    List findAllTrains();

    List<Train> findTrainByEducate(String educate);

    Train findTrainById(String id);

    void updateTrain(Train train);

    void delete(String id);
}
