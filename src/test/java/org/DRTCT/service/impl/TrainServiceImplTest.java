package org.DRTCT.service.impl;

import lombok.RequiredArgsConstructor;
import org.DRTCT.common.ValidateObject;
import org.DRTCT.dto.request.SaveTrainRequest;
import org.DRTCT.repository.TrainRepository;
import org.DRTCT.service.TrainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TrainServiceImplTest extends ValidateObject {

    @Autowired
    TrainService trainService;
    @Autowired
    TrainRepository trainRepository;

    @Test
    void saveTrain() {
        SaveTrainRequest saveTrainRequest = new SaveTrainRequest(
                34703,
                "Uzhavan Express",
                1L,
                2L,
                100,
                10
        );
        validate(saveTrainRequest);
        long count = trainRepository.count();
        trainService.saveTrain(saveTrainRequest);
        assertEquals(count + 1,
                trainRepository.count(),
                "Test case 1 passed");
        assertThrows(DuplicateKeyException.class,
                () -> trainService.saveTrain(saveTrainRequest),
                "Test case 2 passed");
    }

    @Test
    void updateTrain() {
    }
}