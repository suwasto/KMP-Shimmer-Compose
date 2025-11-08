import SwiftUI
import shared

struct ContentView: View {
	var body: some View {
        ComposeView().ignoresSafeArea(edges: .all).ignoresSafeArea(.keyboard)
	}
}

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> some UIViewController {
        return MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {}
}