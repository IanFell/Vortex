package com.tornadogame.ai;

import java.util.Random;

public class Ai {

	public static final int OBJECT_TORNADO = 0;
	public static final int OBJECT_PLAYER  = 1;

	public static final int JUMP       = 0;
	public static final int MOVE_RIGHT = 1;
	public static final int MOVE_LEFT  = 2;
	public static final int MOVE_UP    = 0;
	public static final int MOVE_DOWN  = 3;

	private int[] move            = new int[20];
	private double[] moveDuration = new double[20];
	private int[] timer           = new int[20];

	public Ai(int object) {
		for (int i = 0; i < move.length; i++) {
			// Create random pattern of moves.
			if (object == OBJECT_PLAYER) {
				Random randomMove = new Random();
				move[i] = randomMove.nextInt(3);
				if (i == 3 || i == 6 || i == 9 || i == 14) {
					if (move[i] == JUMP) {
						Random noJump = new Random();
						int randomNoJumpMove = noJump.nextInt(100);
						move[i] = MOVE_RIGHT;
						if (randomNoJumpMove < 40) {
							move[i] = MOVE_LEFT;
						}
					}
				}
			} else {
				Random randomMove = new Random();
				move[i] = randomMove.nextInt(4);
				if (i == 2 || i == 4 || i == 6 || i == 8 || i == 13) {
					if (move[i] == MOVE_RIGHT) {
						move[i] = MOVE_LEFT;
					}
					if (move[i] == MOVE_UP) {
						move[i] = MOVE_DOWN;
					}
				}
			}

			// Create a time length for each move.
			moveDuration[i] = 5 + Math.random() * (30 - 5);

			// Create a timer for each move.
			timer[i] = 0;
		}
	}

	// TODO FIX THIS HORRENDOUS CODE.
	public int executeAi() {
		int currentMove = 0;
		timer[0]++;
		if (timer[0] < moveDuration[0]) {
			currentMove = move[0];
		} else if (timer[0] > moveDuration[0]) {
			if (timer[1] < moveDuration[1]) {
				timer[1]++;
				currentMove = move[1];
			} else if (timer[1] > moveDuration[1]) {
				if (timer[2] < moveDuration[2]) {
					timer[2]++;
					currentMove = move[2];
				} else if (timer[2] > moveDuration[2]) {
					if (timer[3] < moveDuration[3]) {
						timer[3]++;
						currentMove = move[3];
					} else if (timer[3] > moveDuration[3]) {
						if (timer[4] < moveDuration[4]) {
							timer[4]++;
							currentMove = move[4];
						} else if (timer[4] > moveDuration[4]) {
							if (timer[5] < moveDuration[5]) {
								timer[5]++;
								currentMove = move[5];
							} else if (timer[5] > moveDuration[5]) {
								if (timer[6] < moveDuration[6]) {
									timer[6]++;
									currentMove = move[6];
								} else if (timer[6] > moveDuration[6]) {
									if (timer[7] < moveDuration[7]) {
										timer[7]++;
										currentMove = move[7];
									} else if (timer[7] > moveDuration[7]) {
										if (timer[8] < moveDuration[8]) {
											timer[8]++;
											currentMove = move[8];
										} else if (timer[8] > moveDuration[8]) {
											if (timer[9] < moveDuration[9]) {
												timer[9]++;
												currentMove = move[9];
											} else if (timer[9] > moveDuration[9]) {
												if (timer[10] < moveDuration[10]) {
													timer[10]++;
													currentMove = move[10];
												} else if (timer[10] > moveDuration[10]) {
													if (timer[11] < moveDuration[11]) {
														timer[11]++;
														currentMove = move[11];
													} else if (timer[11] > moveDuration[11]) {
														if (timer[12] < moveDuration[12]) {
															timer[12]++;
															currentMove = move[12];
														} else if (timer[12] > moveDuration[12]) {
															if (timer[13] < moveDuration[13]) {
																timer[13]++;
																currentMove = move[13];
															} else if (timer[13] > moveDuration[13]) {
																if (timer[14] < moveDuration[14]) {
																	timer[14]++;
																	currentMove = move[14];
																} else if (timer[14] > moveDuration[14]) {
																	if (timer[15] < moveDuration[15]) {
																		timer[15]++;
																		currentMove = move[5];
																	} else if (timer[15] > moveDuration[15]) {
																		if (timer[16] < moveDuration[16]) {
																			timer[16]++;
																			currentMove = move[16];
																		} else if (timer[16] > moveDuration[16]) {
																			if (timer[17] < moveDuration[17]) {
																				timer[17]++;
																				currentMove = move[17];
																			} else if (timer[17] > moveDuration[17]) {
																				if (timer[18] < moveDuration[18]) {
																					timer[18]++;
																					currentMove = move[18];
																				} else if (timer[18] > moveDuration[18]) {
																					if (timer[19] < moveDuration[19]) {
																						timer[19]++;
																						currentMove = move[19];
																					} else if (timer[19] > moveDuration[19]) {
																						for (int k = 0; k < timer.length; k++) {
																							timer[k] = 0;
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} 
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return currentMove;
	}
}