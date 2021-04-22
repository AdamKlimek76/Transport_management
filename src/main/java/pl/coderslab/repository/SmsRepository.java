package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Sms;

public interface SmsRepository extends JpaRepository<Sms, Long> {
}
