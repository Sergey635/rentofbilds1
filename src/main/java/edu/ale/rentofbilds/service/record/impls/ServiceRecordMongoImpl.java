package edu.ale.rentofbilds.service.record.impls;

import edu.ale.rentofbilds.model.Record;
import edu.ale.rentofbilds.repository.RecordRepository;
import edu.ale.rentofbilds.service.record.interfaces.ICrudRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceRecordMongoImpl implements ICrudRecord {

    @Autowired
    RecordRepository repository;

    @Override
    public Record create(Record record) {
        return null;
    }

    @Override
    public Record get(String id) {
        return null;
    }

    @Override
    public Record update(Record record) {
        return null;
    }

    @Override
    public Record delete(String id) {
        return null;
    }

    @Override
    public List<Record> getAll() {
        return repository.findAll();
    }
}
