package lk.scubes.phonesAndAccessories.asset.goodReceivedNote.dao;


import lk.scubes.phonesAndAccessories.asset.goodReceivedNote.entity.GoodReceivedNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodReceivedNoteDao extends JpaRepository<GoodReceivedNote, Integer> {
}
