package pubSub;      
 
import javax.naming.Context;
import javax.naming.InitialContext;                                                                           
import javax.jms.Topic;

import java.util.Properties;

import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
                                                                            
public class Subscriber
{
    public static void main(String[] args) throws Exception
    {
    	
    	// Obtain a JNDI connection
    	Properties env = new Properties();
    	env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
    	env.put(Context.PROVIDER_URL, "t3://server-name:server-port");
    	env.put(Context.SECURITY_PRINCIPAL,"weblogic");
    	env.put(Context.SECURITY_CREDENTIALS, "weblogic");
    	
       // get the initial context
       InitialContext ctx = new InitialContext(env);
                                                                           
       // lookup the topic object
       Topic topic = (Topic) ctx.lookup("topic/topic0");
                                                                           
       // lookup the topic connection factory
       TopicConnectionFactory connFactory = (TopicConnectionFactory) ctx.
           lookup("topic/connectionFactory");
                                                                           
       // create a topic connection
       TopicConnection topicConn = connFactory.createTopicConnection();
                                                                           
       // create a topic session
       TopicSession topicSession = topicConn.createTopicSession(false,
           Session.AUTO_ACKNOWLEDGE);
                                                                           
       // create a topic subscriber
       TopicSubscriber topicSubscriber = topicSession.createSubscriber(topic);
                                                                           
       // start the connection
       topicConn.start();
                                                                           
       // receive the message
       TextMessage message = (TextMessage) topicSubscriber.receive();
                                                                           
       // print the message
       System.out.println("Message received: " + message.getText());
                                                                           
       // close the topic connection
       topicConn.close();
    }
}