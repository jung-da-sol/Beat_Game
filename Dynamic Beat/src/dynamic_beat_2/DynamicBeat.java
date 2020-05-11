package dynamic_beat_2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	
	private ImageIcon exitButtonEntered = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasic = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon startButtonEntered = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasic = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEntered = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasic = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));

	private ImageIcon leftButtonEntered = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasic = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon rightButtonEntered = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon rightButtonBasic = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));

	private ImageIcon easyButtonEntered = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon easyButtonBasic = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon hardButtonEntered = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	private ImageIcon hardButtonBasic = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));

	private ImageIcon backButtonEntered = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	private ImageIcon backButtonBasic = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));

	private Image Background = new ImageIcon(Main.class.getResource("../images/introbackground.jpg")).getImage();
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png"))); 
	
	private JButton exitButton = new JButton(exitButtonBasic);
	private JButton startButton = new JButton(startButtonBasic);
	private JButton quitButton = new JButton(quitButtonBasic);
	private JButton leftButton = new JButton(leftButtonBasic);
	private JButton rightButton = new JButton(rightButtonBasic);
	private JButton easyButton = new JButton(easyButtonBasic);
	private JButton hardButton = new JButton(hardButtonBasic);
	private JButton backButton = new JButton(backButtonBasic);
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false; //메인스크린
	private boolean isGameScreen = false; //게임스크린
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Music selectedMusic;
	private Image titleImage;
	private Image selectedImage;
	private Music introMusic = new Music("introMusic.mp3", true);
	private int nowSelected = 0;
	
	public static Game game;
	
	public DynamicBeat() {
		
		trackList.add(new Track("Mighty Love Title Image.png", "Mighty Love Start Image.png",
				"Mighty Love Game Image.jpg", "Mighty Love Selected.mp3", "Joakim Karud - Mighty Love.mp3","Joakim Karud - Mighty Love"));
		trackList.add(new Track("Wild Flower Title Image.png", "Wild Flower Start Image.png",
				"Wild Flower Game Image.jpg", "Wild Flower Selected.mp3", "Wild Flower - Joakim Karud.mp3", "Wild Flower - Joakim Karud"));
		trackList.add(new Track("Energy Title Image.png", "Energy Start Image.png",
				"Energy Game Image.png", "Energy Selected.mp3", "Bensound - Energy.mp3","Bensound - Energy"));
		
		
		setUndecorated(true);  //기존 menubar 숨기기
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));  // paintcomponent 흰색
		setLayout(null);
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(DynamicBeat.game == null) {
					return;
				}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					DynamicBeat.game.releaseS();
					
				} else if(e.getKeyCode() == KeyEvent.VK_D) {
					DynamicBeat.game.releaseD();
					
				} else if(e.getKeyCode() == KeyEvent.VK_F) {
					DynamicBeat.game.releaseF();
					
				} else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					DynamicBeat.game.releaseSpace();
					
				} else if(e.getKeyCode() == KeyEvent.VK_J) {
					DynamicBeat.game.releaseJ();
					
				} else if(e.getKeyCode() == KeyEvent.VK_K) {
					DynamicBeat.game.releaseK();
					
				} else if(e.getKeyCode() == KeyEvent.VK_L) {
					DynamicBeat.game.releaseL();
					
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(DynamicBeat.game == null) {
					return;
				}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					DynamicBeat.game.pressS();
					
				} else if(e.getKeyCode() == KeyEvent.VK_D) {
					DynamicBeat.game.pressD();
					
				} else if(e.getKeyCode() == KeyEvent.VK_F) {
					DynamicBeat.game.pressF();
					
				} else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					DynamicBeat.game.pressSpace();
					
				} else if(e.getKeyCode() == KeyEvent.VK_J) {
					DynamicBeat.game.pressJ();
					
				} else if(e.getKeyCode() == KeyEvent.VK_K) {
					DynamicBeat.game.pressK();
					
				} else if(e.getKeyCode() == KeyEvent.VK_L) {
					DynamicBeat.game.pressL();
					
				}
				
			}
		});
		
		introMusic.start();
		
		
		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 올렸을 때	
				exitButton.setIcon(exitButtonEntered);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양으로 바뀌는 것
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //뮤직 한번만 실행
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {  // 마우스 벗어났을 때
				exitButton.setIcon(exitButtonBasic);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //원래상태
			}
			@Override
			public void mousePressed(MouseEvent e) {  //종료
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false); //뮤직 한번만 실행
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);

		
		startButton.setBounds(40, 200, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 올렸을 때	
				startButton.setIcon(startButtonEntered);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양으로 바뀌는 것
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //뮤직 한번만 실행
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {  // 마우스 벗어났을 때
				startButton.setIcon(startButtonBasic);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //원래상태
			}
			@Override
			public void mousePressed(MouseEvent e) {  //종료
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false); //뮤직 한번만 실행
				buttonPressedMusic.start();
				enterMain();
				
			}
		});
		add(startButton);
		
		
		quitButton.setBounds(40, 330, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 올렸을 때	
				quitButton.setIcon(quitButtonEntered);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양으로 바뀌는 것
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //뮤직 한번만 실행
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {  // 마우스 벗어났을 때
				quitButton.setIcon(quitButtonBasic);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //원래상태
			}
			@Override
			public void mousePressed(MouseEvent e) {  //종료
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false); //뮤직 한번만 실행
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 올렸을 때	
				leftButton.setIcon(leftButtonEntered);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양으로 바뀌는 것
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //뮤직 한번만 실행
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {  // 마우스 벗어났을 때
				leftButton.setIcon(leftButtonBasic);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //원래상태
			}
			@Override
			public void mousePressed(MouseEvent e) {  //종료
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false); //뮤직 한번만 실행
				buttonPressedMusic.start();
				selectLeft();
			}
		});
		add(leftButton);
		
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 올렸을 때	
				rightButton.setIcon(rightButtonEntered);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양으로 바뀌는 것
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //뮤직 한번만 실행
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {  // 마우스 벗어났을 때
				rightButton.setIcon(rightButtonBasic);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //원래상태
			}
			@Override
			public void mousePressed(MouseEvent e) {  //종료
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false); //뮤직 한번만 실행
				buttonPressedMusic.start();
				//오른쪽 버튼 이벤트
				selectRight();
			}
		});
		add(rightButton);
		
		
		easyButton.setVisible(false);
		easyButton.setBounds(375, 580, 250, 67);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 올렸을 때	
				easyButton.setIcon(easyButtonEntered);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양으로 바뀌는 것
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //뮤직 한번만 실행
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {  // 마우스 벗어났을 때
				easyButton.setIcon(easyButtonBasic);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //원래상태
			}
			@Override
			public void mousePressed(MouseEvent e) {  //종료
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false); //뮤직 한번만 실행
				buttonPressedMusic.start();
				// 난이도 쉬움 이벤트
				gameStart(nowSelected, "Easy");
			}
		});
		add(easyButton);
		
		
		hardButton.setVisible(false);
		hardButton.setBounds(655, 580, 250, 67);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 올렸을 때	
				hardButton.setIcon(hardButtonEntered);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양으로 바뀌는 것
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //뮤직 한번만 실행
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {  // 마우스 벗어났을 때
				hardButton.setIcon(hardButtonBasic);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //원래상태
			}
			@Override
			public void mousePressed(MouseEvent e) {  //종료
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false); //뮤직 한번만 실행
				buttonPressedMusic.start();
				// 난이도 어려움 이벤트
				gameStart(nowSelected, "Hard");
			}
		});
		add(hardButton);
		
		
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);   // 크기
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 올렸을 때	
				backButton.setIcon(backButtonEntered);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양으로 바뀌는 것
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false); //뮤직 한번만 실행
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {  // 마우스 벗어났을 때
				backButton.setIcon(backButtonBasic);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //원래상태
			}
			@Override
			public void mousePressed(MouseEvent e) {  //종료
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false); //뮤직 한번만 실행
				buttonPressedMusic.start();
				// 메인화면 이벤트
				backMain();
				
			}
		});
		add(backButton);
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
		 @Override
		 public void mousePressed(MouseEvent e) {  //마우스 눌렀을 때
			 mouseX = e.getX();  // X좌표 가져와라
			 mouseY = e.getY();  // Y좌표 가져와라
		 }
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {  //마우스 드래그 했을 때 변하는 X,Y 좌표
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-mouseX, y-mouseY);
			}
		});
		add(menuBar);
		
	}

	
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);  //글자깨짐 개선
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(Background, 0, 0, null);  // 단순히 image
		if(isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		if(isGameScreen) {
			game.screenDraw(g);
		}
		paintComponents(g);   // add() 버튼 보여줘라
		try {
			Thread.sleep(5);
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.repaint(); // 매순간 이미지 갱신
	}
	
	public void selectTrack(int nowSelected) {
		if(selectedMusic != null) 
			selectedMusic.close();
		
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
		
	}
	
	public void selectLeft() {
		if(nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);  //세팅초기화
	}
	
	public void selectRight() {
		if(nowSelected == trackList.size() -1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic != null) 
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		Background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
		backButton.setVisible(true);
		isGameScreen = true;
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
		game.start();
		setFocusable(true);  // 키보드에 집중
	}
	
	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		Background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		backButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
		game.close();
	}
	
	public void enterMain() {
		startButton.setVisible(false);
		quitButton.setVisible(false);
		Background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		isMainScreen = true;
		introMusic.close();
		selectTrack(0);
		
	}

}
