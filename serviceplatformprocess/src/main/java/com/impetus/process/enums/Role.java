package com.impetus.process.enums;

/**
 * @author amitb.kumar
 */
public enum Role
{
  /**
	 * 
	 */
  USER(1, "USER"), /**
	 * 
	 */
  ADMIN(2, "ADMIN");
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
  Role(int id, String name)
  {
    this.id = id;
    this.name = name;
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
