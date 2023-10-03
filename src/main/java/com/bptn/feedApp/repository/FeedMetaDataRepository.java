package com.bptn.feedApp.repository;

import com.bptn.feedApp.jpa.FeedMetaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedMetaDataRepository extends JpaRepository<FeedMetaData, Integer> {
}
