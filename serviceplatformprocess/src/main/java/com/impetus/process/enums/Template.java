package com.impetus.process.enums;

import java.util.Iterator;

public enum Template
{
  FOOD(1, "FOOD"), TRANSPORT(2, "TRANSPORT");
  private int id;
  private String name;

  Template(int id, String name)
  {
    this.id = id;
    this.name = name;
  }

  public static Template getEnum(int id)
  {
    for (Template template : Template.values())
    {
      if (template.getId() == id)
      {
        return template;
      }
    }
    return null;
  }

  /**
   * @return the id
   */
  public int getId()
  {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id)
  {
    this.id = id;
  }

  /**
   * @return the name
   */
  public String getName()
  {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name)
  {
    this.name = name;
  }
}
