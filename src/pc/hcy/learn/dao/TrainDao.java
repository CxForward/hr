package pc.hcy.learn.dao;

import java.util.List;

import pc.hcy.learn.pojo.Train;

public interface TrainDao {
    void save(Train train);

    List findAllTrains();

    List<Train> findTrainByEducate(String educate);

    Train findTrainById(String id);

    void updateTrain(Train train);

    void delete(String id);
}
