package com.bptn.feedApp.controller;
import com.bptn.feedApp.domain.PageResponse;
import com.bptn.feedApp.jpa.Feed;
import com.bptn.feedApp.jpa.FeedMetaData;
import com.bptn.feedApp.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin
@RestController
@RequestMapping("/feeds")
public class FeedController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FeedService feedService;

    @PostMapping
    public Feed createFeed(@RequestBody Feed feed) {

        logger.debug("Creating Feed");

        return this.feedService.createFeed(feed);
    }

    @GetMapping("/{feedId}")
    public Feed getFeed(@PathVariable int feedId){
        logger.debug("Getting Feed, feedId: {}", feedId);
        return this.feedService.getFeedById(feedId);

    }

    @GetMapping("/user/{pageNum}/{pageSize}")
    public PageResponse<Feed> getUserFeeds(@PathVariable int pageNum, @PathVariable int pageSize){
        logger.debug("Getting User Feeds List, pageNum: {}, pageSize: {}", pageNum, pageSize);

        return this.feedService.getUserFeeds(pageNum, pageSize);
    }

    @GetMapping("/other/{pageNum}/{pageSize}")
    public PageResponse<Feed> getOtherUsersFeeds(@PathVariable int pageNum, @PathVariable int pageSize) {

        logger.debug("Getting Other Users Feeds List, pageNum: {}, pageSize: {}", pageNum, pageSize);

        return this.feedService.getOtherUsersFeeds(pageNum, pageSize);
    }

    @PostMapping("/meta/{feedId}")
    public FeedMetaData createFeedMetaData(@PathVariable int feedId, @RequestBody FeedMetaData meta) {

        logger.debug("Creating FeedMetaData, feedId: {}", feedId);

        return this.feedService.createFeedMetaData(feedId, meta);
    }

    @DeleteMapping("/{feedId}")
    public void deleteFeed(@PathVariable int feedId) {

        logger.debug("Deleting Feed, feedId: {}", feedId);

        this.feedService.deleteFeed(feedId);
    }

}
