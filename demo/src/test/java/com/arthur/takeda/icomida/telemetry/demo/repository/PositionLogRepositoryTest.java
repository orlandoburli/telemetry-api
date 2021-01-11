package com.arthur.takeda.icomida.telemetry.demo.repository;
import com.arthur.takeda.icomida.telemetry.demo.model.PositionLog;
import com.arthur.takeda.icomida.telemetry.demo.testFactory.PositionLogTestFactory;
import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PositionLogRepositoryTest {

    @Autowired
    private PositionLogRepository repository;

    @Test
    public void testPositionLogSaveWithAllArguments(){
        PositionLog positionLog = new PositionLogTestFactory().positionLog(1l);

        compare(positionLog, repository.save(positionLog));
    }

    @Test
    public void testPositionLogSaveWithNoArguments(){
        PositionLog positionLog = new PositionLog();

        Assertions.assertThrows(ConstraintViolationException.class, () -> repository.save(positionLog));
    }

    @Test
    public void testPositionLogSaveWithAllArgumentsButLatitude(){
        PositionLog positionLog = new PositionLogTestFactory().positionLog(1l);

        positionLog.setLatitude(null);

        Assertions.assertThrows(ConstraintViolationException.class, () -> repository.save(positionLog));
    }

    @Test
    public void testPositionLogSaveWithAllArgumentsWithLatitudePastMaxValue(){
        PositionLog positionLog = new PositionLogTestFactory().positionLog(1l);

        positionLog.setLatitude(new BigDecimal(91));

        Assertions.assertThrows(ConstraintViolationException.class, () -> repository.save(positionLog));
    }

    @Test
    public void testPositionLogSaveWithAllArgumentsWithLatitudePastMinValue(){
        PositionLog positionLog = new PositionLogTestFactory().positionLog(1l);

        positionLog.setLatitude(new BigDecimal(-91));

        Assertions.assertThrows(ConstraintViolationException.class, () -> repository.save(positionLog));
    }

    @Test
    public void testPositionLogSaveWithAllArgumentsButLongitude(){
        PositionLog positionLog = new PositionLogTestFactory().positionLog(1l);

        positionLog.setLongitude(null);

        Assertions.assertThrows(ConstraintViolationException.class, () -> repository.save(positionLog));
    }

    @Test
    public void testPositionLogSaveWithAllArgumentsWithLongitudePastMaxValue(){
        PositionLog positionLog = new PositionLogTestFactory().positionLog(1l);

        positionLog.setLongitude(new BigDecimal(181));

        Assertions.assertThrows(ConstraintViolationException.class, () -> repository.save(positionLog));
    }

    @Test
    public void testPositionLogSaveWithAllArgumentsWithLongitudePastMinValue(){
        PositionLog positionLog = new PositionLogTestFactory().positionLog(1l);

        positionLog.setLongitude(new BigDecimal(-181));

        Assertions.assertThrows(ConstraintViolationException.class, () -> repository.save(positionLog));
    }

    @Test
    public void testPositionLogSaveWithAllArgumentsButBattery(){
        PositionLog positionLog = new PositionLogTestFactory().positionLog(1l);

        positionLog.setBattery(null);

        Assertions.assertThrows(ConstraintViolationException.class, () -> repository.save(positionLog));
    }

    @Test
    public void testPositionLogSaveWithAllArgumentsWithBatteryPastMaxValue(){
        PositionLog positionLog = new PositionLogTestFactory().positionLog(1l);

        positionLog.setBattery(101);

        Assertions.assertThrows(ConstraintViolationException.class, () -> repository.save(positionLog));
    }

    @Test
    public void testPositionLogSaveWithAllArgumentsWithBatteryPastMinValue(){
        PositionLog positionLog = new PositionLogTestFactory().positionLog(1l);

        positionLog.setBattery(0);

        Assertions.assertThrows(ConstraintViolationException.class, () -> repository.save(positionLog));
    }

    @Test
    public void testPositionLogSaveWithAllArgumentsButDeliverymanId(){
        PositionLog positionLog = new PositionLogTestFactory().positionLog(1l);

        positionLog.setDeliverymanId(null);

        Assertions.assertThrows(ConstraintViolationException.class, () -> repository.save(positionLog));
    }

    private void compare(PositionLog expected, PositionLog actual){
        Assertions.assertAll(
                () -> Assertions.assertNotNull(expected.getPositionLogId()),
                () -> Assertions.assertEquals(expected.getBattery(), actual.getBattery()),
                () -> Assertions.assertEquals(expected.getDeliverymanId(), actual.getDeliverymanId()),
                () -> Assertions.assertEquals(expected.getLatitude(), actual.getLatitude()),
                () -> Assertions.assertEquals(expected.getLongitude(), actual.getLongitude())
        );
    }
}
