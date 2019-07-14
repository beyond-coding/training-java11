package com.beyondcoding.java11.stream.advanced.sms;

import com.beyondcoding.java11.filesandpaths.FileReader;

import java.util.List;
import java.util.stream.Collectors;

public class SmsReader {

  private FileReader reader = new FileReader();
  private String filePath = "com/beyondcoding/java11/stream/advanced/sms/sms.csv";

  public List<Sms> getSms() {
    return reader.asStream(filePath)
                 .skip(1)
                 .map(e -> e.split(";"))
                 .filter(e -> e.length > 1)
                 .map(e -> new Sms(e[0], e[1]))
                 .collect(Collectors.toList());
  }

}
