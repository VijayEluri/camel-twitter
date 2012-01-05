package org.apache.camel.component.twitter.consumer.timeline;

import java.util.Iterator;
import java.util.List;

import org.apache.camel.Processor;
import org.apache.camel.component.twitter.TwitterEndpoint;
import org.apache.camel.component.twitter.consumer.TwitterConsumerPolling;
import org.apache.camel.component.twitter.data.Status;
import org.apache.camel.component.twitter.util.TwitterConverter;

import twitter4j.TwitterException;

public class PollingPublicConsumer extends TwitterConsumerPolling {

	public PollingPublicConsumer(TwitterEndpoint endpoint, Processor processor) {
		super(endpoint, processor);
	}

	@Override
	protected Iterator<Status> requestStatus() throws TwitterException {
		TwitterEndpoint te = (TwitterEndpoint) getEndpoint();
		List<twitter4j.Status> statusList = te.getTwitter().getPublicTimeline();
		return TwitterConverter.convertStatuses(statusList).iterator();
	}

}
