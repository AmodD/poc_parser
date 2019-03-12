package com.fortiate;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.fortiate.parser.Strings;
import com.fortiate.parser.field.CompoundField;
import com.fortiate.parser.field.FixedCompoundField;
import com.fortiate.parser.field.IsoField;

public class ParserKafkaConsumer {

	public static void main(String[] args) {
		
		 Properties properties = new Properties();
	        properties.put("bootstrap.servers", "localhost:9092");
	        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	        properties.put("group.id", "test-group");

	        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
	        List<String> topics = new ArrayList<String>();
	        topics.add("my-replicated-topic");
	        kafkaConsumer.subscribe(topics);
	        try{

        //        System.out.println("try 1");

	  //      	byte[] bytes;
    //            String lines;
  //              bytes = Files.readAllBytes(Paths.get(kafkaconsumer.class.getResource("iso_field.xml").toURI()));

//                System.out.println("try 2");

	        	
	      //  	if(false) {
	            while (true){
	                ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(1000));
	                for (ConsumerRecord<String, String> record: records){
	                    System.out.println(String.format("Topic - %s, Partition - %d, Value: %s", record.topic(), record.partition(), record.value()));
	                    
	                    System.out.println("started 6");
	                    
	                    byte[] bytes;
	                    String lines;
	                    bytes = Files.readAllBytes(Paths.get(ParserKafkaConsumer.class.getResource("iso_field.xml").toURI()));

	                  //  bytes = Files.readAllBytes(Paths.get(kafkaconsumer.class.getResource("/iso_field.xml").toURI()));
	                  
	                      lines = new String(bytes, "ISO-8859-1");
	                    IsoField isoField = Strings.unmarshal(lines, IsoField.class, "application/xml");
	                    CompoundField field = new FixedCompoundField(isoField);
	                    field.decode(record.value());
	                    
	                    System.out.println("finished");
	                }
	            }
	        }catch (Exception e){
	            System.out.println(e.getCause());
	        }finally {
	            kafkaConsumer.close();
	        }
	        
	
	}//end of main
	
}//end of class
