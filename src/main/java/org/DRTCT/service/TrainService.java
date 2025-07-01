package org.DRTCT.service;

import org.DRTCT.dto.request.SaveTrainRequest;
import org.DRTCT.dto.response.TrainResponse;
import org.DRTCT.entity.Train;

public interface TrainService {

    TrainResponse saveTrain(SaveTrainRequest saveTrainRequest);
    TrainResponse updateTrain(SaveTrainRequest saveTrainRequest, Long id);
    Train getTrainById(Long id);

}
