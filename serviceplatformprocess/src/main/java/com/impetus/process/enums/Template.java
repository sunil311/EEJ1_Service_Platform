package com.impetus.process.enums;

/**
 * @author amitb.kumar
 */
public enum Template
{
  /**
   * 
   */
  FOOD(1, "FOOD"), /**
   * 
   */
  TRANSPORT(2, "TRANSPORT");
  /**
   * 
   */
  private int id;
  /**
   * 
   */
  private String name;

  /**
   * @param id
   * @param name
   */
  Template(int id, String name)
  {
    this.id = id;
    this.name = name;
  }

  /**
   * @param id
   * @return
   */
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
  /**
   * @return
   */
  public int getId()
  {
    return id;
  }

  /**
   * @param id the id to set
   */
  /**
   * @param id
   */
  public void setId(int id)
  {
    this.id = id;
  }

  /**
   * @return the name
   */
  /**
   * @return
   */
  public String getName()
  {
    return name;
  }

  /**
   * @param name the name to set
   */
  /**
   * @param name
   */
  public void setName(String name)
  {
    this.name = name;
  }
}
